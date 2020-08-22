
// Clase groovy que hereda de GTC
class NonEmptyPilaSimpleTest extends GroovyTestCase {
// Definiciuón de nuestro elemento a probar
private stack
// Al igual que en JUnit podemos contar con este método
void setUp() {
    // Inicializació del elemento
    stack = new PilaSimple()
    // Agregamos 3 elementos a la pila
    [ "a", "b", "c" ].each{ x -> stack.push x }
}

// Los métodos de prueba inician con la palabra 'test'
void testPreCondiciones() {
    // La pila no esta vacia
    assert !stack.isEmpty()
}

void testPushAndPeek() {
    // Agregamos un elemeneto
    stack.push "d"
    // Observamos el último elemento agregado
    assert stack.peek() == "d"
}

void testPushPopAndPeek() {
    // Introducimos un elemento
    stack.push "anything"
    // Sacamos el elemento
    stack.pop()
    // Observamos el elemento en el tope de la pila
    assert stack.peek() == "c"
}

}