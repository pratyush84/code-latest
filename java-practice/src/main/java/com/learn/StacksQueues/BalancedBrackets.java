package com.learn.StacksQueues;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println(isBalanced("]({}{()}[}}[]{]([]{}({({(][})}{)[[(})][)})(){(}{){]][(}(][{[])(]]([[{{(]]{}([}]]){[[({]}[(}][(]){[]}])}{]])][([][([)]{[}()])}[{][]{{(]{[][){[)([}]}[{}(({{({)}()}}{{{{}[}]}){})[((}[[}[[}(\n" +
                "}[(]}[][)({]([][)}[)[]))({(]}{}][)[]()})})}{{{{{}{])(}[}][{({][))}[{]]]])[[){(()}}})){[]](([{]([}}])((}{}}(]}])])]{[]}{){[{{]([]})[}})]()({[([}(]{}){)))[({(]{})(({{}({{[{[{))()]{(([)])[{]}]))(]{}}[}[{()))())[{}]]])][])}{]][)]]])[}{]}{}[[{[]]({(()))(](}}}][}}}{]}(}){}}}{({}[{(]}[[[]({}{}}}}}{))[}))][}((([}[)}[({}[]}[[]}[]([]{(]{]}])]]){[(]}{)()((}){][{]}[{){}{){}{[])}}(}((}]([({}](]}}[{}{]}({)]{[]]}((](}{[[]{))[]{{{{])[{(}{({]}}}})[]}{)][){]}({]]]}{{{}[](}}({{{])][[{}[]]}[[}{}{[[(])([{()){(){]](}}}((]]{]]{([]({)(}](]}}{))]{](){([}}})}{[{([[]])(}{(]{)][))))]}[{({(}({]{[)}][]}]{)()(])((}{)]()({)}({}[]{(](){}({[}{){](})]]([([[[{}[()]{{{(]()}{)(})[[{{}(])(][((]]){(]}"));
    }

    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character chr : s.toCharArray()){
            if (chr.equals('(') || chr.equals('[') || chr.equals('{')){
                stack.push(chr);
            } else if(!stack.empty()) {
                Character top = stack.peek();
                if((top.equals('(') && chr.equals(')')
                || (top.equals('{') && chr.equals('}'))
                || (top.equals('[') && chr.equals(']'))
                ) ){
                    stack.pop();
                } else
                    return "NO";

            }

        }

        if(stack.empty()){
            return "YES";
        } else
            return "NO";
    }
}