package com.crm.auxiliares;

import java.sql.SQLException;
import java.util.List;

import com.crm.pojos.Cliente;

public interface Servicios{
	public void addCliente(Cliente cli) throws SQLException;
	public Cliente updatecli(Cliente cli) throws SQLException;
	public void borrarcli(int id)  throws SQLException;
	public List <Cliente> getAllClientes()throws SQLException;
	public Cliente getcliById(int id);
	Cliente getById(int id);
}
