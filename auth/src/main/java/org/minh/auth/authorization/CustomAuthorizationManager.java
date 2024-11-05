package org.minh.auth.authorization;

import org.aopalliance.intercept.MethodInvocation;
import org.minh.auth.annotation.Policy;
import org.minh.auth.entity.User;
import org.minh.auth.constant.PolicyEnum;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;

import java.util.Optional;
import java.util.function.Supplier;

public class CustomAuthorizationManager<T> implements AuthorizationManager<MethodInvocation> {

    private final AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();

    @Override
    public void verify(Supplier<Authentication> authentication, MethodInvocation object) {
        AuthorizationManager.super.verify(authentication, object);
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, MethodInvocation object) {

        if (hasAuthentication(authentication.get())) {

            Policy policyAnnotation = AnnotationUtils.findAnnotation(object.getMethod(), Policy.class);

            User user = (User) authentication.get().getPrincipal();

            return new AuthorizationDecision(Optional.ofNullable(policyAnnotation)
                    .map(Policy::value)
                    .filter(policy -> isValidPolicy(policy, user))
                    .isPresent()
            );

        }

        return new AuthorizationDecision(false);
    }

    private boolean isValidPolicy(PolicyEnum policy, User user) {
        return policy == PolicyEnum.OPEN || (policy == PolicyEnum.RESTRICTED && user.isAccessToRestrictedPolicy());
    }

    private boolean hasAuthentication(Authentication authentication) {
        return authentication != null && isNotAnonymous(authentication) && authentication.isAuthenticated();
    }

    private boolean isNotAnonymous(Authentication authentication) {
        return !this.trustResolver.isAnonymous(authentication);
    }
}
