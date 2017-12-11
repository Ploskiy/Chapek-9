package by.ploskiy.entitys;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Repository
@Scope("prototype")
public class Task {

    private String title;
    private String type;
}