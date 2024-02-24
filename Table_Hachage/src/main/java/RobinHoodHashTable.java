public class RobinHoodHashTable<AnyType> extends QuadraticProbingHashTable<AnyType> {
    public RobinHoodHashTable(){
        super();
    }

    public RobinHoodHashTable(int size){
        super(size);}


    private void insert(HashEntry<AnyType> incoming) {
        enum InsertState {
            POSITION_INITIALE,
            ITERATION,
            INVERSER,
            DUPLICATION,
            ZERO,
            VERIF_COLLISION,
            COLLISION,
            INSERT,
            FIN
        }

        int offset = 0;
        int currentPos = probe(incoming, offset);
        InsertState state = InsertState.POSITION_INITIALE;

        while (state != InsertState.FIN) {
            switch (state) {
                case POSITION_INITIALE:
                    state = InsertState.DUPLICATION;
                    break;

                case ITERATION:
                    offset += 1;
                    currentPos = probe(incoming, offset);
                    state = InsertState.DUPLICATION;
                    break;

                case INVERSER:
                    currentPos = probe(incoming, offset);
                    state = InsertState.DUPLICATION;
                    break;

                case DUPLICATION:
                    if (contains(incoming.element) != -1) {
                        state = InsertState.FIN;
                    } else {
                        state = InsertState.ZERO;
                    }
                    break;

                case ZERO:
                    if (incoming.element.equals(0)) {
                        state = InsertState.FIN;
                    } else {
                        state = InsertState.VERIF_COLLISION;
                    }
                    break;

                case VERIF_COLLISION:
                    if (array[currentPos] != null) {
                        state = InsertState.COLLISION;
                    } else {
                        state = InsertState.INSERT;
                    }
                    break;

                case COLLISION:
                    if (incoming.probeDistance > array[currentPos].probeDistance) {
                        swap(incoming, array, currentPos);
                        if (incoming.isActive)
                        {
                            state = InsertState.INVERSER;
                        }
                        else
                        {
                            state = InsertState.FIN;
                        }
                    }
                    else
                    {
                        state = InsertState.ITERATION;
                    }
                    break;

                case INSERT:

                    array[currentPos] = incoming;
                    currentSize++;
                    if (needsRehash()) {
                        rehash();
                    }
                    state = InsertState.FIN;
                    break;

                case FIN:
                    break;
            }
        }
    }

    private int probe(HashEntry<AnyType> x, int i){
        x.probeDistance = i;
        return (x.element.hashCode()+ i*i)% array.length;
    }

    private void swap(HashEntry<AnyType> x, HashEntry<AnyType>[] arr, int pos) {
        AnyType tempElement = x.element;
        int tempProbeDistance = x.probeDistance;

        x.element = arr[pos].element;
        x.probeDistance = arr[pos].probeDistance;

        arr[pos].element = tempElement;
        arr[pos].probeDistance = tempProbeDistance;
    }

    private boolean needsRehash() {
        return currentSize > array.length * 0.5;
    }

    @Override
    public int contains(AnyType x) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].isActive && array[i].element.equals(x)) {
                return i; // Element found at position i
            }
        }
        return -1; // Element not found
    }

    @Override
    public void insert(AnyType x) {
        HashEntry<AnyType> X = new HashEntry<>(x);
        this.insert(X);
    }
}

/*Mettre ici votre réponse pour executionTimeTest

 *Starting Gradle Daemon...
Gradle Daemon started in 2 s 273 ms

> Task :compileJava UP-TO-DATE
> Task :processResources NO-SOURCE
> Task :classes UP-TO-DATE
> Task :compileTestJava UP-TO-DATE
> Task :processTestResources UP-TO-DATE
> Task :testClasses UP-TO-DATE
> Task :test
oct. 15, 2023 6:07:39 P.M. org.junit.platform.launcher.core.EngineDiscoveryOrchestrator lambda$logTestDescriptorExclusionReasons$7
INFOS: 0 containers and 5 tests were Method or class mismatch
BUILD SUCCESSFUL in 10s
4 actionable tasks: 1 executed, 3 up-to-date
18:07:39: Execution finished ':test --tests "RobinHoodTest.executionTimeTest"'.
 * */
