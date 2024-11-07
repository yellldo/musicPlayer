package com.music.player.auth.bo;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * user type of author
 */
@Setter
@Getter
@ToString(callSuper = true)
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class UserTypeAuthorBo extends UserTypeBaseBo {

    private String authorName;

    private String country;

    private String city;

    private String gender;
}
