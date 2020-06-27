   public class NameIterator implements Iterator {

      int index;
      Container cont;

      public NameIterator(Container c) {
    	  this.cont = c;
    	  
      }
      
      @Override
      public boolean hasNext() {
      
         if(index < (cont.getRepository()).length){
            return true;
         }
         return false;
      }

      @Override
      public Object next() {
      
         if(this.hasNext()){
            return (cont.getRepository())[index++];
         }
         return null;
      }		
   }
