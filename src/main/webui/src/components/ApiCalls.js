const menuUrl = 'http://localhost:8080/spiritanimals/assign';

export async function getMenu(props) {
    const response = await fetch(menuUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: name
    });
    const data = await response.json();
    console.log(data);
    return data;
};