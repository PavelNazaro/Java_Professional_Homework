package Lesson1.Task3;

public class Box {
    private final float weightApple = 1.0f;
    private final float weightOrange = 1.5f;

    private String name;
    private String type;
    private float count;

    public Box(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public float getCount() {
        return count;
    }

    public float getWeight(){
        float weight;
        if (type.equals("Apple")){
            weight = count * weightApple;
        }
        else{
            weight = count * weightOrange;
        }
        return weight;
    }

    public boolean compare(Box boxOutside){
        if (getWeight() == boxOutside.getWeight()){
            return true;
        }
        return false;
    }

    public void throwFruit(Box boxToThrow){
        //Проверка на тип фрукта
        if (type.equals(boxToThrow.type)){
            float countToThrow = getCount();
            boxToThrow.setCount(countToThrow);
            setCount(0.0f);
            System.out.println("Фрукты перемещены успешно!");
            System.out.println("В коробке " + name + " количество " + type + ": " + count);
            System.out.println("В коробке " + boxToThrow.name + " количество " + boxToThrow.type + ": " + boxToThrow.count);
        }
        else{
            System.out.println("Нельзя смешивать яблоки с апельсинами!");
        }
    }
}
