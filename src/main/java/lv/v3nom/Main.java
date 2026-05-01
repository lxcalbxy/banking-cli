package lv.v3nom;

import lv.v3nom.infrastructure.di.DIContainer;
import lv.v3nom.infrastructure.di.impl.DIContainerImpl;

public class Main {
    static void main() {
        DIContainer container = new DIContainerImpl();
    }
}
