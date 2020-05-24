/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import java.awt.Color;

/**
 *
 * @author kavanpatel
 */
public class Context {
    private Strategy strategy;
    
    public Context(Strategy strategy)
    {
        this.strategy=strategy;
    }
    
    public void executeStrategy(Color c)
    {
        strategy.execute(c);
    }
}
