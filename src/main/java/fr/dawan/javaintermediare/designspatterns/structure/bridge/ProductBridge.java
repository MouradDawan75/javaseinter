package fr.dawan.javaintermediare.designspatterns.structure.bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductBridge implements Bridge{
    @Override
    public List<ProductEntity> getAllProducts(Object systemeExterne) {

        List<ProductEntity> result = new ArrayList<>();

        if(systemeExterne instanceof SystemeExterne1){
            SystemeExterne1 sys1 = (SystemeExterne1) systemeExterne;

            result = sys1.getProducts()
                    .stream()
                    .map(p -> new ProductEntity(p.getId(), p.getName()))
                    .collect(Collectors.toList());

        }
        else if(systemeExterne instanceof SystemeExterne2){
            SystemeExterne2 sys2 = (SystemeExterne2) systemeExterne;
            result = sys2.getProducts()
                    .stream()
                    .map(p -> new ProductEntity(p.getId(), p.getDescription()))
                    .collect(Collectors.toList());
        }


        return result;
    }
}
