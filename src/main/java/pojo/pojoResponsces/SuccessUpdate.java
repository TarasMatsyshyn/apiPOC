package pojo.pojoResponsces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SuccessUpdate {
    private String name;
    private String job;
    private Date updatedAt;
}
