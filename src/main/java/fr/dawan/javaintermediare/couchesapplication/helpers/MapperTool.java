package fr.dawan.javaintermediare.couchesapplication.helpers;

import org.modelmapper.ModelMapper;

public class MapperTool {

    private static ModelMapper mapper = new ModelMapper();

    public static <TSource, TDestination> TDestination convert(TSource src, Class<TDestination> clazz){
        return mapper.map(src, clazz);
    }
}
