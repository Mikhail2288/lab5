import java.util.Objects;

public class fraction implements interfacefraction{// сущность дробь
    private int numerator;
    private int denominator;

    public fraction(int numerator, int denominator) {//конструктор
        if (denominator == 0) throw new RuntimeException("Знаменатель не должен быть равен 0!");
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
        else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public double getDecimalValue() {
        return (double) numerator / denominator;
    }


    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }


    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        this.denominator = denominator;
    }

    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }


    public String toString() {//строковое представление вида “числитель/знаменатель”
        return numerator + "/" + denominator;
    }

    public fraction sum(fraction otherfraction) {//сложение дробей
        return new fraction(this.numerator * otherfraction.denominator + this.denominator * otherfraction.numerator, this.denominator * otherfraction.denominator);
    }

    public fraction minus(fraction otherfraction) {//вычитание
        return new fraction(this.numerator * otherfraction.denominator - this.denominator * otherfraction.numerator, this.denominator * otherfraction.denominator);
    }

    public fraction multiply(fraction otherfraction) {//умножение
        return new fraction(this.numerator * otherfraction.numerator, this.denominator * otherfraction.denominator);
    }

    public fraction divide(fraction otherfraction) {//деление
        if (otherfraction.numerator == 0) throw new ArithmeticException("Числитель не может быть равен 0 у дроби на которую делят в функции деления.");
        return new fraction(this.numerator * otherfraction.denominator, this.denominator * otherfraction.numerator);
    }

    public fraction sum(int integer) {//сумма с целым числом
        return new fraction(this.numerator + integer * this.denominator, this.denominator);
    }

    public fraction minus(int integer) { //вычитание с целым числом
        return new fraction(this.numerator - integer * this.denominator, this.denominator);
    }

    public fraction multiply(int integer) {//умножениес целым числом
        return new fraction(this.numerator * integer, this.denominator);
    }

    public fraction divide(int integer) {//деление с целым числом
        return new fraction(this.numerator, this.denominator * integer);
    }
    public boolean equals(Object o) {
        if (this == o) return true;//проверка ссылок, если одинаковые то True
        if (o == null || getClass() != o.getClass()) return false;//проверка на null и на соответствие классов.
        fraction other = (fraction) o;//создние локальной переменной other типа fraction
        return numerator == other.numerator && denominator == other.denominator;//если все значения равны, то объекты считаются равными.
    }
}
