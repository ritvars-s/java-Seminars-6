package lv.venta.service;

import java.util.ArrayList;

import org.jspecify.annotations.Nullable;

import lv.venta.model.Student;

public interface IStudentCRUDService extends ICRUDServiceBase<Student>{
	//CRUD prieks studenta - retrieve all treive by id delete by id ir ServiceBase interfaceisa
	
	//C -create
	public abstract void create(String newName, String newSurname) throws Exception;
	
	//U - update by id
	
	public abstract void updateById(long id, String newName, String newSurname) throws Exception;

	public ArrayList<Student> retrieveAll() throws Exception;
	
	
}
