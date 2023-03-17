package test;

import java.util.Date;
import java.util.List;

import dao.CategorieDaoImpl;
import dao.ProduitDaoImpl;
import metier.entities.Categorie;
import metier.entities.Produit;

public class TestDao {
public static void main(String[] args) {
ProduitDaoImpl pdao= new ProduitDaoImpl();
CategorieDaoImpl cdao = new CategorieDaoImpl();
Date d = new Date();
Categorie c = cdao.save(new Categorie("telephone",d));
Produit prod= pdao.save(new Produit("iphone 8 plus",2800,c));
System.out.println(prod);
List<Produit> prods =pdao.produitsParMC("iphone");
for (Produit p : prods)
System.out.println(p);

}
}