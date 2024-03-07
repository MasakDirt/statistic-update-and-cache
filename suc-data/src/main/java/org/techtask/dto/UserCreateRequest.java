package org.techtask.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Data
@Getter
@Builder
public class UserCreateRequest {

    @NotEmpty(message = "Fill in the field with the name.")
    private String fullName;

    @NotNull(message = "Must be a valid e-mail address")
    @Pattern(regexp = "[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}",
            message = "Must be a valid e-mail address")
    private String email;

    @NotBlank(message = "The password cannot be 'blank'")
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreateRequest that = (UserCreateRequest) o;
        return Objects.equals(fullName, that.fullName)
                && Objects.equals(email, that.email)
                && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return 77 * Objects.hash(fullName, email, password);
    }
}
