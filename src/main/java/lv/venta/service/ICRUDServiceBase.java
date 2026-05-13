package lv.venta.service;

import java.util.ArrayList;


//Ttpe template datutips kas pielagosies velak jau konkretaja CRUD interface
public interface ICRUDServiceBase<Ttype> {
	//CRUD -ka baze tam funkcijam kuras var sablonizet - retrieveAll , retrieve by id delete by id
	//R -retrieve all
	public abstract ArrayList<Ttype> retrieveAll() throws Exception;
	// R retrieve by id
	public abstract Ttype retrieveByID(long id) throws Exception;
	//D - delete by id
	public abstract void deleteByID(long id) throws Exception;
	
}
