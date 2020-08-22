@Grapes(
    @Grab(group='org.spockframework', module='spock-core', version='0.7-groovy-2.0')
    )

import spock.lang.Specification
class GivenWhenThenSpec extends Specification {
    
    def "Agregar un nuevo item a un set"() {
        given:
        def bag = [4, 6, 3, 2] as Set
        
        when: 
        bag << 1
        
        then:
        bag.size() == 5
    }

}