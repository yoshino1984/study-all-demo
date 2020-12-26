package jvm.layout.object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JavaObjectModel {

    private int id;
    private String type;
    private double price;
    private char level;
}
