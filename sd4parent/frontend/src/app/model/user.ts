export class User {
  id: string;
  login: string;
  password: string;
  role: string;

  static cloneBase(user: User): User {
    let clonedUser: User = new User();
    clonedUser.id = user.id;
    clonedUser.login = user.login;
    clonedUser.password = user.password;
    clonedUser.role = user.role;
    return clonedUser;
  }
}
