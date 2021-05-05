package com.films.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

@Data
@Document(collection = "films")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Film {
    @Id
    private String id;
    @NotBlank(message = "Please provide a name.")
    private String name;
    @NotBlank(message = "Please provide a description.")
    private String description;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @NotNull(message = "Please provide a date whit the format dd-MM-yyyy HH:mm")
    private LocalDateTime releaseDate;

    private Rating rating = Rating.ONE_STAR;

    @NotNull
    private BigDecimal ticketPrice;
    @NotBlank
    private String     country;

    @NotNull
    private Genre genre=Genre.ANIMATION;

    private Binary image;



}
