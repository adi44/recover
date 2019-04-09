constructor(
				address ifSuccessfulSendTo,
				uint fundingGoalInEthers,
				uint durationinMinutes,
				uint etherCostOfEachTocken,
				address addressofTokenUsedAsReward
			) public
				{
						beneficiary = ifSuccessfulSendTo;
						fundingGoal = fundingGoalInEtheres * 1 ether;
						deadline = now + durationInMinutes * 1 minutes;
						price = etherCostOfEachToken * 1 etherl
						tokenReward = token(addressofTokenUSedAsReward);
				}
function () payable external {
	require(!crowdsaleClosed);
	uint amount = msg.value;
	balanceOf[msg.sender] +=amount;
	amountRaised +=amount;
	tokenReward.transfer(msg.sender, amount/price);
	emit FundTransfer(msg.sender, amount, true);
}

modifier afterDeadline()
	{
		if(now>=deadline) -; 
	}
	function checkGoalReached() public afterdeadline {
		if(amountRaised >fundingGoal)
		{
			fundingGoalReached = true;
			emit GoalReached(beneficiary, amountRaised);
		}
	crowdsaleClosed =true;
	}
function safeWithdrawal() public afterDeadline {
	if(!fundingGoalReached)
		{
			uint amount =balanceOf[msg.sender];
			balanceOf[msg.sender]=0;
			if(amount>0)
				{
					if(msg.sender.send(amount))
						{
							emit FundTransfer(msg.sender, amount, false);
						}
					else
						{
							balanceOf[msg.sender] = amount;
						}
				}
		}
}

if(fundingGoalReached && beneficiary==msg.sender)
	{
		if(msg.sender.send(amountRaised))
			{
				emit FundTransfer(beneficiary, amountRaised, false);
			}
		else{
				fundingGoalReached = false;
		}
	}

