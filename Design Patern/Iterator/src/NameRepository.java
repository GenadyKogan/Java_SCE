public class NameRepository implements Container {
   public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

   @Override
   public Iterator getIterator() {
	  
      return new NameIterator(this);
   }
   
   public Object[] getRepository() {
	   return names;
   }
  
}