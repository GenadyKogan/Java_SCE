
public class Program {
	public static void main(String[] args) {
		Team t1=new Team("Maccacbi",50);
		Coach c1=new Coach("gogo", 12);
		t1.setCoach(c1);
		//c1.setTeam(t1);
		t1.show();
		//c1.show();
	}
}
