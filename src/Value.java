/**
 * Created by JafarAtili on 18/05/2016.
 */


//Values is an object with two integer attributes, val which is the value, pointer which is a pointer to another Value

public class Value {

    private int val;
    private int pointer;

    public Value(int _val, int _pointer){
        val = _val;
        pointer = _pointer;
    }

    public int getVal (){
        return val;
    }

    public void copy (Value v){
        val = v.getVal();
        pointer = v.getPointer();

    }

    public int getPointer(){
        return pointer;
    }


    public void setVal(int _val){
        val = _val;
    }

    public void setPointer(int _pointer){
        pointer = _pointer;
    }

}
