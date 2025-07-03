package fr.dawan.javaintermediare.designspatterns.comportement.visitor;

public class XmlExport implements Visitor{
    @Override
    public void Visit(Rectangle rec) {
        //export rec en xml
    }

    @Override
    public void Visit(Cercle c) {
        //export cercle en xml
    }
}
