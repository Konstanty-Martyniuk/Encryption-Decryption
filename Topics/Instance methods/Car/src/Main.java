class Car {

    int yearModel;
    String make;
    int speed;

    void accelerate() {
        this.speed += 5;
    }
    void brake() {
        this.speed = (this.speed) >= 5 ? this.speed - 5 : 0;
    }
}