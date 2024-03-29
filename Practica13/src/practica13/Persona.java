/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica13;
public class Persona {

	private String nombre;
	private int edad;
	private String municipio;
	private String colegio;
	private String lugarTrabajo;
	
	private Persona() {}
	
	
	public static class Builder {
		private Persona persona;
		
		public Builder(String nombre) {
			persona = new Persona();
			persona.nombre = nombre;
		}
		
		public Builder setMunicipio (String municipio) {
			persona.municipio = municipio;
			return this;
		}
		
		public BuilderMayor setMayor(int edad) {
			if (edad < 18) throw new IllegalArgumentException("es menor de edad " + edad);
			persona.edad = edad;
//			persona.lugarTrabajo = lugarTrabajo;
//			persona.colegio = null;
			return new Persona.BuilderMayor(persona);
		}
		
		public BuilderMenor setMenor(int edad) {
			if (edad >= 18) throw new IllegalArgumentException("es mayor de edad " + edad);
			persona.edad = edad;
//			uhnu
			return new Persona.BuilderMenor(persona);
		}
	
		public Persona build() {
			return persona;
		}

	}
        public static class BuilderMayor {
            private Persona persona;
            public BuilderMayor(Persona persona){
                this.persona=persona;
        }
        public BuilderMayor setLugarTrabajo(String lugarTrabajo){
            this.persona.lugarTrabajo=lugarTrabajo;
            return this;
        }
        public Persona build(){
            return persona;
        }
}
        public static class BuilderMenor {
            private Persona persona;
            public BuilderMenor(Persona persona){
                this.persona=persona;
        }
        public BuilderMenor setColegio(String colegio){
            this.persona.colegio=colegio;
            return this;
        }
        public Persona build(){
            return persona;
        }
	
}
}