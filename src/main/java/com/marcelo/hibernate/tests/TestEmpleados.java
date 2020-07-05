package com.marcelo.hibernate.tests;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.marcelo.hibernate.model.Empleado;

public class TestEmpleados {

	private static EntityManager manager;
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("Empleado");
		manager = emf.createEntityManager();
		insertInicial();
		imprimirTodo();
		manager.getTransaction().begin();
		Empleado e = manager.find(Empleado.class, 10L);
		e.setApellido("Laguna");
		e.setNombre("Rosa");
		manager.getTransaction().commit();
		imprimirTodo();
		manager.close();
	}

	public static void insertInicial() {

		Empleado e = new Empleado(10L, "Gutierrez", "Marcelo", LocalDate.of(1988, 3, 29));
		Empleado e2 = new Empleado(15L, "Gutierrez", "Jazmin", LocalDate.of(2008, 9, 18));

		manager.getTransaction().begin();
		manager.persist(e);
		manager.persist(e2);
		manager.getTransaction().commit();
	}

	public static void imprimirTodo() {

		@SuppressWarnings("unchecked")
		List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		System.out.println("En esta bd hay " + empleados.size() + " empleados.");
		for (Empleado emp : empleados) {
			System.out.println(emp);
		}
	}
}
