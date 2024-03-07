package org.techtask.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.*;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    @NotNull
    private HttpStatus status;


    @NotEmpty(message = "Message must be filled in!")
    private String message;

    @NotEmpty(message = "Path cannot be empty or null!")
    private String path;

}
