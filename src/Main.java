import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final ArrayList<String> LOTTERY_BALL_COLORS = new ArrayList<>(
			Arrays.asList("金", "赤", "緑", "青", "黄", "白"));
	static ArrayList<Integer> lotteryBallAmounts = new ArrayList<Integer>();
	static final ArrayList<String> GIFTS = new ArrayList<>(
			Arrays.asList("ルンバ", "炭酸水メーカー", "卓上加湿器", "マスクセット", "クリスタルガイザー", "ティッシュ"));
	static Scanner sc = new Scanner(System.in);
	static int customerNumber = 0;
	static int total = 0;
	static final String CONGRATURATION = "おめでとうございます!";

	public static void main(String[] args) {
		lotteryBallAmounts = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 10, 20));
		for (int amount : lotteryBallAmounts) {
			total += amount;
		}
		while (true) {
			System.out.println("抽選券をお持ちですか？");
			System.out.println("YかNを入力してください");
			boolean lotteryTicket;
			while (true) {
				String answer = sc.nextLine();
				if ("Y".equals(answer) || "y".equals(answer)) {
					lotteryTicket = true;
					System.out.println("3回してください");
					break;
				} else if ("N".equals(answer) || "n".equals(answer)) {
					lotteryTicket = false;
					System.out.println("1回してください");
					break;
				} else {
					System.out.println("YかNを入力してください");
				}
			}
			customerNumber++;
			if (lotteryTicket) {
				for (int i = 0; i < 3; i++) {
					turnLottery((i + 1) + "個目：");
				}
			} else {
				turnLottery("");
			}
		}
	}

	public static void turnLottery(String lotteryTimes) {
		System.out.println("Press Enter");
		sc.nextLine();
		int rand = (int) (Math.random() * total);
		int targetIndex = 0;
		int counter = 0;
		for (int i = 0; i < lotteryBallAmounts.size(); i++) {
			counter += lotteryBallAmounts.get(i);
			if (counter > rand) {
				targetIndex = i;
				break;
			}
		}

		total--;
		String congraturation = "";
		if (targetIndex == 0 || targetIndex == 1 || targetIndex == 2) {
			lotteryBallAmounts.set(targetIndex, lotteryBallAmounts.get(targetIndex) - 1);
			congraturation = CONGRATURATION;
		}
		String prize = (targetIndex + 1) + "等です。";
		if (targetIndex == 0) {
			prize = "特賞です。";
		}
		System.out.println(
				lotteryTimes + LOTTERY_BALL_COLORS.get(targetIndex) + "色の玉が出ました。" + congraturation + prize
						+ GIFTS.get(targetIndex) + "を差し上げます。");
		System.out.println("◆◆◆　お客様" + customerNumber
				+ "人目　残り抽選玉" + total + "個　特賞残" + lotteryBallAmounts.get(0) + "　2等残" + lotteryBallAmounts.get(1)
				+ "　3等残"
				+ lotteryBallAmounts.get(2) + "  ◆◆◆");
		System.out.println("----------------------------------------------------------------------");

		if (lotteryBallAmounts.get(0) == 0 && lotteryBallAmounts.get(1) == 0
				&& lotteryBallAmounts.get(2) == 0) {
			System.out.println("豪華景品が当たる!ガラポン抽選を終了します。沢山のご参加ありがとうございました。");
			sc.close();
			System.exit(0);
		}
	}
}
