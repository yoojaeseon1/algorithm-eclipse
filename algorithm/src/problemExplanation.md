#### 라면 공장(RemenFactoryFail)

Fail code에서

        for(int datesI = 0; datesI < dates.length; datesI = supplyIndex+1) { // problem 1
            
            int supplyAmount = -1;
        
            while(true) {
                if(datesI < dates.length && dates[datesI] <= today+stock) {
                    if(supplyAmount < dates[datesI] + supplies[datesI])
                        supplyAmount = supplies[datesI];
                        supplyIndex = datesI; // problem 2
                        
                } else
                    break;
                datesI++;
            }
            
            today += stock;
            stock = supplyAmount;
            numSupplyment++;
            
            if(today+stock >= k)
                return numSupplyment;
        }
		return supplyIndex;

##### problem 1

	datesI = supplyIndex+1;

밑의 while문에서 공급받을 수 있는 범위를 정하고 그 안에서 최선의 선택인 한 날짜에만 공급을 받았다.

그리고 그 범위 다음 인덱스부터 공급받을 날을 선택했는데

그 이후의 인덱스에서 여러 번 공급받아야 할 수도 있다.

이전의 인덱스에서 차선이 되는 공급도 같이 받았을 경우 최소한의 공급횟수를 만들 수도 있기 때문에

실패한 코드다.

##### problem 2

이 부분에서 최선의 선택인 인덱스를 초기화한다.

##### 근본적인 problem

예외 케이스를 생각하는 능력 부족