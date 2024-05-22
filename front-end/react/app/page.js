/*
  ※ Next에서 useState는 Server Component에서는 실행되지 않는다.
  Next에서는 기본적으로 Server Component로 사용하게 되어 있다.
*/

import LikeButton from './like-button';
 
function Header({ title }) {
  return <h1>{title ? title : 'Default title'}</h1>;
}
 
export default function HomePage() {
    const names = ['Ada Lovelace', 'Grace Hopper', 'Margaret Hamilton'];
 
    return (
      <div>
        <Header title="Develop. Preview. Ship." />
        <ul>
          {names.map((name) => (
            <li key={name}>{name}</li>
          ))}
        </ul>
        <LikeButton />
      </div>
    );
}