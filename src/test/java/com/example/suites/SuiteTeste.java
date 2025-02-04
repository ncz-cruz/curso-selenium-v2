package com.example.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.example.test.TesteAlert;
import com.example.test.TesteCadastro;
import com.example.test.TesteCampoTreinamento;
import com.example.test.TesteFramesyJanelas;
import com.example.test.TesteRules;
import com.example.test.TesteRulesCadastro;

@RunWith(Suite.class)
@SuiteClasses({
    TesteRules.class,
    TesteRulesCadastro.class,
    TesteCampoTreinamento.class,
    TesteAlert.class,
    TesteFramesyJanelas.class,
    TesteCadastro.class,
    TesteRules.class,
    TesteRulesCadastro.class
})

public class SuiteTeste {

}
