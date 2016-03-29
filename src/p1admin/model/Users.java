package p1admin.model;

import java.util.Date;
import java.util.List;


public class Users {
	private String email;
	private String password;
	private String nombre;
	private String genero;
	private String interes;
	private String descripcion;
	private int latitud;
	private int longitud;
	private Date fecha;
	private byte foto;
	private List<Users> amigos;
	public Users(String email, String password){
		this.email = email;
		this.password = password;
		
	}
	public String getEmail(){
		return this.email;
	}
	public String getPassword(){
		return this.password;
	}
	public String getNombre(){
		return this.nombre;
	}
	public String getGenero(){
		return this.genero;
	}
	public String getInteres(){
		return this.interes;
	}
	public String getDescripcion(){
		return this.descripcion;
	}
	public int getLatitud(){
		return this.latitud;
	}
	public int getLongitud(){
		return this.longitud;
	}
	public Date getFecha(){
		return this.fecha;
	}
	public byte getFoto(){
		return this.foto;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public void setGenero(String genero){
		this.genero = genero;
	}
	public void setInteres(String interes){
		this.interes = interes;
	}
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	public void setLatitud(int latitud){
		this.latitud = latitud;
	}
	public void setLongitud(int longitud){
		this.longitud = longitud;
	}
	public void setFecha(Date fecha){
		this.fecha = fecha;
	}
	public void setFoto(byte foto){
		this.foto = foto;
	}
}
