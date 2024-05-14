public record Moneda(float conversion_result) {

    @Override
    public String toString() {
        return this.conversion_result +"";
    }
}
