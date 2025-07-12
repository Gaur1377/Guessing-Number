# import Task as pl
# score = 0
# i =0
# play = "yes"
# while play.__eq__("yes"):
#     print("Welcome to 10 question Quiz Game ")
#     print("challenge your History and political Knowledge")
#     print("Rule are mention below")
#     print("Rule #1.only choose one Answer From A, B, C and D option")
#     print("Rule #2.correct answer will give you 5 Score .")
#     print("Rule #3. Any incorrect answer will result in game over ")
#     print("Rule #4.To win the Game you have to score 50 out of 50   ")
#     score = 0
#     i = 0
#     while i < 10:
#         q = pl.quiz[i]
#         print(q['Question'])
#         for option in q['option']:
#             print(option)
#         ans = input("Your Answer is choice option :").strip().upper()
#         # choose correct option is eupal orginal option
#         if ans == q['answer']:
#             score += 5
#             print("✅ Correct!",score)
#
#         else:
#             print("❌ Wrong. The correct answer was " ,q['answer'],".")
#             # break
#         i = i + 1
#     if score >= 35:
#         print("\n🎉 Congratulation You have win the quiz😊😊!")
#         print(f"Your score: {score}/{50}")
#         print("would you like Play again ? Yes Or No\n")
#         play = input().lower()
#     else:
#
#         print("\n Your total ", score)
#         print("Game over : ")
#         print("would you like Play again ? Yes Or No\n")
#         play = input().lower()