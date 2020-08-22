class EmptyPilaSimpleTest extends GroovyTestCase {
    // Definición de la pila
    private stack = new PilaSimple()
    // La pila esta vacía
    void testPreConditions() {
    assert stack.isEmpty()
}

    // Como la pila esta vacía esto arroja excepcion
    void testPeekWithEmptyStack() {
        // Uso de shouldFail, para que tenga exito debe arrojar excepción
        shouldFail(RuntimeException) {
        stack.peek()
        }
    }

    void testPopWithEmptyStack() {
        shouldFail(RuntimeException) {
        stack.pop()
        }
    }
}