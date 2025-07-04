package fr.dawan.javaintermediare.designspatterns.structure.bridge;

import java.util.List;

/**
 * Interface qui décrit le rôle du Pattern Bridge
 */
public interface Bridge {

    List<ProductEntity> getAllProducts(Object systemeExterne);
}
