 class Money{
        int amount
        String currency
    Money plus(Money other){
      if(null == other) return this
      if(other.currency != currency){
        throw new IllegalArgumentException("Invalid operation[$other.currency + $currency]")
      }
      return new Money(amount:amount + other.amount, currency:currency)
    }

    String toString(){
      "\$ $amount $currency"
    }
  }

  Money money1 = new Money(amount:23,currency:'MXN')
  Money money2 = new Money(amount:12,currency:'MXN')

  println money1 + money2
