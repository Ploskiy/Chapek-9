package by.ploskiy.entitys;

import lombok.*;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Repository
public class Task {

    private String title;
    private String type;
}