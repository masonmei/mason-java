package org.personal.mason.feop.oauth.service.spi.impl;

import org.personal.mason.feop.oauth.service.domain.OauthUser;
import org.personal.mason.feop.oauth.service.spi.OUserContext;
import org.personal.mason.feop.oauth.service.spi.OUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * NOTE: This is no longer used. See {@link SpringSecurityUserContext}.
 *
 * Returns the same user for every call to {@link #getCurrentUser()}. This is used prior to adding security, so that the
 * rest of the application can be used.
 *
 * @author Rob Winch
 * @see SpringSecurityUserContext
 */
//@Component
public class OUserContextStub implements OUserContext {
    private final OUserService userService;
    /**
     * The {@link CalendarUser#getId()} for the user that is representing the currently logged in user. This can be
     * modified using {@link #setCurrentUser(CalendarUser)}
     */
    private Long currentUserId = null;

    @Autowired
    public OUserContextStub(OUserService userService) {
        if (userService == null) {
            throw new IllegalArgumentException("userService cannot be null");
        }
        this.userService = userService;
    }

    @Override
    public OauthUser getCurrentUser() {
        return userService.findUserById(currentUserId);
    }

    @Override
    public void setCurrentUser(OauthUser user) {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }
        Long currentId = user.getId();
        if(currentId == null) {
            throw new IllegalArgumentException("user.getId() cannot be null");
        }
        this.currentUserId = currentId;
    }
}