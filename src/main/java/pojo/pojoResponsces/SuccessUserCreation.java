package pojo.pojoResponsces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SuccessUserCreation {
    public String name;
    public String job;
    public String id;
    public Date createdAt;
}
