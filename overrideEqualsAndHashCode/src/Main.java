
/*equals
hashCode
getClass
finalize
notify
notifyAll
wait
wait(type)
toString
clone*/

class A{
    int value;

    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(!(o instanceof A)){
            return false;
        }
        return this.value==((A) o).value;
    }

    public int hashCode(){
        return value;
    }
}

public class Main {
}