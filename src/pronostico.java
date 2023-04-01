public class pronostico {

   private partido partido;
   private equipo equipo;
   private resultadoenum resultado;

   public pronostico(partido partido, equipo equipo, resultadoenum resultado) {

       this.partido = partido;
       this.equipo= equipo;
       this.resultado = resultado;

   }
   public partido getPartido() {
       return partido;
   }
   public equipo getEquipo() {
       return equipo;
   }
   public resultadoenum getResultado() {
       return resultado;
   }
 public int puntos () {
       if (partido.resultado(this.equipo)==this.resultado) {
           return 1;
       }
       return 0;
 }
}
