import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DAEJEON06_HEODAEUN {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "DAEJEON06_HEODAEUN";

	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final float BALL_R = (float) 5.73;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int) balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				// - order: 1인 경우 선공, 2인 경우 후공을 의미
				// - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				// 예) balls[0][0]: 흰 공의 X좌표
				// balls[0][1]: 흰 공의 Y좌표
				// balls[1][0]: 1번 공의 X좌표
				// balls[4][0]: 4번 공의 X좌표
				// balls[5][0]: 마지막 번호(8번) 공의 X좌표

				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

				int[][] orders = new int[][] { {},{ 1, 3 }, { 2, 4 }, { 8 } };
				boolean flag = false;
				int cnt = 0;
				List<float[]> ballList = new ArrayList<>();
				// whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
				float whiteBall_x = balls[0][0];
				float whiteBall_y = balls[0][1];

				float targetBall_x = 0;
				float targetBall_y = 0;
				for (int i : orders[order]) {
					// targetBall_x, targetBall_y: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수
					if (balls[i][0] != -1 && balls[i][1] != -1) {
						targetBall_x = balls[i][0];
						targetBall_y = balls[i][1];
						List<Integer> holeList = new ArrayList<>();
						if (whiteBall_y < targetBall_y) { // 흰 공보다 위쪽이면
							// 위쪽 홀
							for (int j = 3; j < 6; j++) {
								if (whiteBall_x < targetBall_x && HOLES[j][0] > targetBall_x) { // 흰 공보다 오른쪽이면
									// 타겟보다 오른쪽 홀
									holeList.add(j);
								} else if (whiteBall_x > targetBall_x && HOLES[j][0] < targetBall_x) { // 흰 공보다 왼쪽이면
									// 타겟보다 왼쪽 홀
									holeList.add(j);
								}
							}

						} else if (whiteBall_y > targetBall_y) { // 흰 공보다 아래쪽이면
							// 아래쪽 홀
							for (int j = 0; j < 3; j++) {
								if (whiteBall_x < targetBall_x && HOLES[j][0] > targetBall_x) { // 흰 공보다 오른쪽이면
									// 타겟보다 오른쪽 홀
									holeList.add(j);
								} else if (whiteBall_x > targetBall_x && HOLES[j][0] < targetBall_x) { // 흰 공보다 왼쪽이면
									// 타겟보다 왼쪽 홀
									holeList.add(j);
								}
							}
						}
						/// 어떤 홀에 넣을지까지 함

						for (int h : holeList) {
							float holeX = HOLES[h][0];
							float holeY = HOLES[h][1];
							// 홀과 타겟공의 각도
							float hole_width = Math.abs(targetBall_x - holeX);
							float hole_height = Math.abs(targetBall_y - holeY);
							double hole_radian = hole_height > 0 ? Math.atan(hole_width / hole_height) : 0;
							float hole_angle = (float) ((180.0 / Math.PI) * hole_radian);

							// 타겟공이 가야할 홀위치가 2사분면에 위치했을 때 각도를 재계산
							if (targetBall_x > holeX && targetBall_x < holeY) {
								hole_radian = Math.atan(hole_width / hole_height);
								hole_angle = (float) (((180.0 / Math.PI) * hole_radian) + 270);
							}

							// 타겟공이 가야할 홀위치가 3사분면에 위치했을 때 각도를 재계산
							else if (targetBall_x > holeX && targetBall_x > holeY) {
								hole_radian = Math.atan(hole_width / hole_height);
								hole_angle = (float) (((180.0 / Math.PI) * hole_radian) + 180);
							}

							// 타겟공이 가야할 홀위치가 4사분면에 위치했을 때 각도를 재계산
							else if (targetBall_x < holeX && targetBall_x > holeY) {
								hole_radian = Math.atan(hole_width / hole_height);
								hole_angle = (float) (((180.0 / Math.PI) * hole_radian) + 90);
							}

							// 타겟볼와 흰공의 각도 구하기
							float target_width = Math.abs(targetBall_x - whiteBall_x);
							float target_height = Math.abs(targetBall_y - whiteBall_y);
							double target_radian = target_height > 0 ? Math.atan(target_width / target_height) : 0;
							float target_angle = (float) ((180.0 / Math.PI) * target_radian);

							// 흰 공이 가야할 타겟위치가 2사분면에 위치했을 때 각도를 재계산
							if (whiteBall_x > targetBall_x && whiteBall_y < targetBall_y) {
								target_radian = Math.atan(target_width / target_height);
								target_angle = (float) (((180.0 / Math.PI) * target_radian) + 270);
							}

							// 흰 공이 가야할 타겟위치가 3사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x > targetBall_x && whiteBall_y > targetBall_y) {
								target_radian = Math.atan(target_width / target_height);
								target_angle = (float) (((180.0 / Math.PI) * target_radian) + 180);
							}

							// 흰 공이 가야할 타겟위치가 4사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x < targetBall_x && whiteBall_y > targetBall_y) {
								target_radian = Math.atan(target_width / target_height);
								target_angle = (float) (((180.0 / Math.PI) * target_radian) + 90);
							}

							ballList.add(new float[] { Math.abs(hole_angle - target_angle), targetBall_x, targetBall_y,
									target_width, target_height, target_angle, h });
						}
					} else {
						cnt++;
						if (cnt == 2)
							flag = true;
					}
				}

				if (flag) {
					{
						targetBall_x = balls[5][0];
						targetBall_y = balls[5][1];
						List<Integer> holeList = new ArrayList<>();
						if (whiteBall_y < targetBall_y) { // 흰 공보다 위쪽이면
							// 위쪽 홀
							for (int j = 3; j < 6; j++) {
								if (whiteBall_x < targetBall_x && HOLES[j][0] > targetBall_x) { // 흰 공보다 오른쪽이면
									// 타겟보다 오른쪽 홀
									holeList.add(j);
								} else if (whiteBall_x > targetBall_x && HOLES[j][0] < targetBall_x) { // 흰 공보다 왼쪽이면
									// 타겟보다 왼쪽 홀
									holeList.add(j);
								}
							}

						} else if (whiteBall_y > targetBall_y) { // 흰 공보다 아래쪽이면
							// 아래쪽 홀
							for (int j = 0; j < 3; j++) {
								if (whiteBall_x < targetBall_x && HOLES[j][0] > targetBall_x) { // 흰 공보다 오른쪽이면
									// 타겟보다 오른쪽 홀
									holeList.add(j);
								} else if (whiteBall_x > targetBall_x && HOLES[j][0] < targetBall_x) { // 흰 공보다 왼쪽이면
									// 타겟보다 왼쪽 홀
									holeList.add(j);
								}
							}
						}
						/// 어떤 홀에 넣을지까지 함

						for (int h : holeList) {
							float holeX = HOLES[h][0];
							float holeY = HOLES[h][1];
							// 홀과 타겟공의 각도
							float hole_width = Math.abs(targetBall_x - holeX);
							float hole_height = Math.abs(targetBall_y - holeY);
							double hole_radian = hole_height > 0 ? Math.atan(hole_width / hole_height) : 0;
							float hole_angle = (float) ((180.0 / Math.PI) * hole_radian);

							// 타겟공이 가야할 홀위치가 2사분면에 위치했을 때 각도를 재계산
							if (targetBall_x > holeX && targetBall_x < holeY) {
								hole_radian = Math.atan(hole_width / hole_height);
								hole_angle = (float) (((180.0 / Math.PI) * hole_radian) + 270);
							}

							// 타겟공이 가야할 홀위치가 3사분면에 위치했을 때 각도를 재계산
							else if (targetBall_x > holeX && targetBall_x > holeY) {
								hole_radian = Math.atan(hole_width / hole_height);
								hole_angle = (float) (((180.0 / Math.PI) * hole_radian) + 180);
							}

							// 타겟공이 가야할 홀위치가 4사분면에 위치했을 때 각도를 재계산
							else if (targetBall_x < holeX && targetBall_x > holeY) {
								hole_radian = Math.atan(hole_width / hole_height);
								hole_angle = (float) (((180.0 / Math.PI) * hole_radian) + 90);
							}

							// 타겟볼와 흰공의 각도 구하기
							float target_width = Math.abs(targetBall_x - whiteBall_x);
							float target_height = Math.abs(targetBall_y - whiteBall_y);
							double target_radian = target_height > 0 ? Math.atan(target_width / target_height) : 0;
							float target_angle = (float) ((180.0 / Math.PI) * target_radian);

							// 흰 공이 가야할 타겟위치가 2사분면에 위치했을 때 각도를 재계산
							if (whiteBall_x > targetBall_x && whiteBall_y < targetBall_y) {
								target_radian = Math.atan(target_width / target_height);
								target_angle = (float) (((180.0 / Math.PI) * target_radian) + 270);
							}

							// 흰 공이 가야할 타겟위치가 3사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x > targetBall_x && whiteBall_y > targetBall_y) {
								target_radian = Math.atan(target_width / target_height);
								target_angle = (float) (((180.0 / Math.PI) * target_radian) + 180);
							}

							// 흰 공이 가야할 타겟위치가 4사분면에 위치했을 때 각도를 재계산
							else if (whiteBall_x < targetBall_x && whiteBall_y > targetBall_y) {
								target_radian = Math.atan(target_width / target_height);
								target_angle = (float) (((180.0 / Math.PI) * target_radian) + 90);
							}

							ballList.add(new float[] { Math.abs(hole_angle - target_angle), targetBall_x, targetBall_y,
									target_width, target_height, target_angle, h });
						}
					}
				}

				Collections.sort(ballList, new Comparator<float[]>() {
					@Override
					public int compare(float[] o1, float[] o2) {
						// TODO Auto-generated method stub
						return (int) (o1[0] - o2[0]);
					}
				});
				for (float[] b : ballList) {
					System.out.println(Arrays.toString(b));
				}
				System.out.println();
				float result_x = ballList.get(0)[1];
				float result_y = ballList.get(0)[2];
				float result_width = ballList.get(0)[3];
				float result_height = ballList.get(0)[4];
				float result_angle = ballList.get(0)[5];

				// 목적구가 상하좌우로 일직선상에 위치했을 때 각도 입력
				if (whiteBall_x == result_x) {
					if (whiteBall_y < result_y) {
						result_angle = 0;
					} else {
						result_angle = 180;
					}
				} else if (whiteBall_y == result_y) {
					if (whiteBall_x < result_x) {
						result_angle = 90;
					} else {
						result_angle = 270;
					}
				}

				// distance: 두 점(좌표) 사이의 거리를 계산
				double distance = Math.sqrt((result_width * result_width) + (result_height * result_height))*3.1;

				// power: 거리 distance에 따른 힘의 세기를 계산
				power = (float) distance;
				power = 100;
				angle = result_angle;
				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				// - angle: 흰 공을 때려서 보낼 방향(각도)
				// - power: 흰 공을 때릴 힘의 세기
				//
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////
				System.out.println(result_x + " " + result_y);
				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
}
