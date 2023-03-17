package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.entities.Categorie;
import metier.entities.Produit;
import util.JPAutil;
public class ProduitDaoImpl implements IProduitDao {
private EntityManager entityManager=JPAutil.getEntityManager("TP6_JEE");
@Override
public Produit save(Produit p) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(p);
tx.commit();
return p;
}
@Override
public List<Produit> produitsParMC(String mc) {
List<Produit> prods = entityManager.createQuery("select p from Produit p where p.nomProduit like :mc")
.setParameter("mc", "%"+mc+"%")
.getResultList();
		 return prods;
		}
		@Override
		public Produit getProduit(Long id) {
		 return entityManager.find(Produit.class, id);
		}
		@Override
		public Produit updateProduit(Produit p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(p);
		tx.commit();
		return p;
		}
		@Override
		public void deleteProduit(Long id) {
		Produit produit = entityManager.find(Produit.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(produit);
		entityManager.getTransaction().commit();
		}
		@Override
		public List<Produit> produitsParIdCat(Long idCat) {
			//ICategorieDao iCat = new  CategorieDaoImpl();
			//Categorie c = iCat.getCategorie(idCat);
			
			List<Produit> prods = entityManager.createQuery("select p from Produit p where p.categorie.idCat = :c")
					.setParameter("c", idCat)
					.getResultList();
							 return prods;
		}
		}