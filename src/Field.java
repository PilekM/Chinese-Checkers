
public class Field 
{
 private int base=0;
 private boolean field=false;
 
 void changeField(boolean bul)
 {
	this.field=bul;
 }
 
 void changeBase(int i) 
 {
	this.base=i; 
 }
 
 int getBase() {
	 return this.base;
 }
 
 boolean getField() {
	 return this.field;
 }
}
