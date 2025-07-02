package fr.dawan.javaintermediare.designspatterns.creation.builder;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString(of = {"id", "name"})
@EqualsAndHashCode(of = {"id"})
@Builder
//@Data
public class Product {

    private int id;
    private String name;
}
