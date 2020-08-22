 public class HolaMundo {
        private String name;
        public String getName() {
          return name;
        }
        public void setName(String name) {
          this.name = name;
        }
        public String greet() {
          return "Hola " + this.name + " !!!";
        }
        public static void main(String[] args) {
          HolaMundo objeto = new HolaMundo();
          objeto.setName("Omar");
          System.out.println(objeto.greet());
        }
      }